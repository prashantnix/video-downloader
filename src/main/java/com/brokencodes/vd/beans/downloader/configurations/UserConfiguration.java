package com.brokencodes.vd.beans.downloader.configurations;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class UserConfiguration {

    @Id
    private String id;

    private String downloadDirectory;

    private boolean shouldStoreDownloadsInIndividualDirectory;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )
    @JoinColumn(name = "id")
    @MapsId
    private ProxyConfiguration proxyConfiguration;

    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE, CascadeType.PERSIST}
    )
    @JoinColumn(name = "user_configuration_id")
    private Set<DownloadProfile> downloadProfiles;

}

