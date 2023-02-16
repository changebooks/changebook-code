package io.github.changebooks.code.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 服务器ip
 *
 * @author changebooks@qq.com
 */
public final class ServerIp {
    /**
     * localhost address
     */
    private final String address;

    public ServerIp() throws UnknownHostException {
        address = InetAddress.getLocalHost().getHostAddress();
    }

    public String getAddress() {
        return address;
    }

}
