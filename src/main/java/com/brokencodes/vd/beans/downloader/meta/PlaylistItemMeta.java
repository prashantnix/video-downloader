package com.brokencodes.vd.beans.downloader.meta;

import java.net.URI;
import java.time.LocalDateTime;

public class PlaylistItemMeta {

    /**
     * ID of the {@link PlaylistItem} whose metadata is contained in this class.
     */
    private String id;

    /**
     * Title of the {@link PlaylistItem}.
     */
    private String title;

    /**
     * Description of {@link PlaylistItem}.
     */
    private String description;

    /**
     * Permanent {@link java.net.URI} linking this {@link PlaylistItem}
     */
    private URI url;

    /**
     * Duration of play.
     */
    private Long duration;

    /**
     * Id of the uploader.
     */
    private String uploader;

    /**
     * Total count of up votes for this video at the time of download.
     */
    private Long upVotesCount;

    /**
     * Total count of down votes for the video at the time of download.
     */
    private Long downVotesCount;

    /**
     * Total number of view the video has at the time of download.
     */
    private Long views;

    /**
     * When was the video uploaded to Youtube?
     */
    private LocalDateTime uploadedOn;

    /**
     * {@link PlaylistMeta} to which this metadata belong to.
     */
    private PlaylistMeta playlistMeta;

}
