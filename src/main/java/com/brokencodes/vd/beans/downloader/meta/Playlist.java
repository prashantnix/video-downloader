package com.brokencodes.vd.beans.downloader.meta;

import com.brokencodes.vd.beans.downloader.Storage;

import java.util.List;

public class Playlist {

    private String id;

    private String extractor;

    private String type;

    private String uploader;

    private List<Video> entries;

    private Thumbnail thumbnail;

    private String title;

    private String uploaderId;

    private String uploaderUrl;

    private Auditing auditMeta;

    private Storage storage;

}
