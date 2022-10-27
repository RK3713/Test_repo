package com.template.webserver;

import net.corda.client.rpc.CordaRPCClient;
import net.corda.client.rpc.CordaRPCConnection;
import net.corda.core.messaging.CordaRPCOps;
import net.corda.core.utilities.NetworkHostAndPort;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Wraps an RPC connection to a Corda node.
 *
 * The RPC connection is configured using command line arguments.
 */
@Component
public class NodeRPCConnection implements AutoCloseable {
    private static final Logger logger = LoggerFactory.getLogger(NodeRPCConnection.class);
    // The host of the node we are connecting to.
    @Value("${config.rpc.host}")
    private String host;
    // The RPC port of the node we are connecting to.
    @Value("${config.rpc.username}")
    private String username;
    // The username for logging into the RPC client.
    @Value("${config.rpc.password}")
    private String password;
    // the nodename
//    @Value("${nodename}")
//    private String nodename;
    // The password for logging into the RPC client.
    @Value("${config.rpc.port}")
    private int rpcPort;

    private CordaRPCConnection rpcConnection;
    CordaRPCOps proxy;

    @PostConstruct
    public void initialiseNodeRPCConnection() {
        logger.info(String.format("RPConnector [host=%s, username=%s, nodename=%s]", host, username));
        NetworkHostAndPort rpcAddress = new NetworkHostAndPort(host, rpcPort);
        CordaRPCClient rpcClient = new CordaRPCClient(rpcAddress);
        rpcConnection = rpcClient.start(username, password);
        proxy = rpcConnection.getProxy();
        //logger.info(String.format("connected to via RPC to %s", nodename));
        proxy.networkMapSnapshot();
    }

    public CordaRPCOps getRPCops() {
        return proxy;
    }

    public String getRpcAddress() {
        return host;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

//    public String getNodeName() {
//        return nodename;
//    }

    @PreDestroy
    public void close() {
        rpcConnection.notifyServerAndClose();
    }
}