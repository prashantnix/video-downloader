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
public class DownloadProfile {

    @Id
    private String id;

    private String profileName;

    private boolean shouldAddIndexToDownloadedFiles;

    private boolean isMultiThreadingEnabled;

    private int maxParallelDownloads;

}
