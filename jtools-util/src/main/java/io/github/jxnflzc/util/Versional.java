package io.github.jxnflzc.util;

import io.github.jxnflzc.util.annotation.Version;
import org.apache.commons.lang3.StringUtils;

public interface Versional {
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
        }

        return result.toString();
    }
}
