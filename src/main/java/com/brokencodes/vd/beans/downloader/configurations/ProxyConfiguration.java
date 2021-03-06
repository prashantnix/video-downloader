package com.brokencodes.vd.beans.downloader.configurations;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class ProxyConfiguration {

    @Id
    private String id;

    private String url;

    private int port;

    private String username;

    private String password;

    private boolean isProxyEnabled;

}
