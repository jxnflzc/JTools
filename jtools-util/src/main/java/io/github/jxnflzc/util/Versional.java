package io.github.jxnflzc.util;

import io.github.jxnflzc.util.annotation.Version;
import io.github.jxnflzc.util.exception.VersionException;

/**
 * @author jxnflzc
 * @date 2021/5/18
 */
public interface Versional {
    /**
     * Default method to get version info.
     * @return version string
     */
    default String getVersionInfo() {
        StringBuilder result = new StringBuilder();

        Version version = this.getClass().getAnnotation(Version.class);
        if (null != version) {
            result.append(version.prefix());
            result.append(version.major());
            result.append(".");
            result.append(version.minor());
            result.append(".");
            result.append(version.build());
            if (version.isSnapshot()) {
                result.append("-SNAPSHOT");
            }
        } else {
            throw new VersionException("Version annotation not found.");
        }

        return result.toString();
    }
}
