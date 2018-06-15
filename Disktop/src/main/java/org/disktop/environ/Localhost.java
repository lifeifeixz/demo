package org.disktop.environ;

import org.springframework.util.ClassUtils;

/**
 * Created by flysLi on 2017/8/25.
 */
public class Localhost {
    public static String location() {
        return ClassUtils.getDefaultClassLoader().getResource("").getPath();
    }
}
