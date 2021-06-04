package io.github.jxnflzc.util;

import io.github.jxnflzc.util.annotation.Version;
import io.github.jxnflzc.util.exception.VersionException;
import org.apache.commons.lang3.StringUtils;

/**
 * @author jxnflzc
 * @version 1.0.202105191555
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

    /**
     * Default method to get author info.
     * @return version string
     */
    default String getAuthorInfo() {
        StringBuilder result = new StringBuilder();

        Version version = this.getClass().getAnnotation(Version.class);
        if (null != version) {
            String[] authors = version.authors();
            if (authors.length > 0) {
                result.append("Authors:");
                result.append(StringUtils.join(authors, ","));
            } else {
                throw new VersionException("There is not author info.");
            }
        } else {
            throw new VersionException("Version annotation not found.");
        }

        return result.toString();
    }

    /**
     * Default method to show whether the class has version annotation
     * @return Class has version annotation or not
     */
    default boolean isVersional() {
        Version version = this.getClass().getAnnotation(Version.class);
        return null != version;
    }
}
