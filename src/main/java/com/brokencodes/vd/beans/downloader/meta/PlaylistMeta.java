package com.brokencodes.vd.beans.downloader.meta;

import java.time.LocalDateTime;
import java.util.List;

public class PlaylistMeta {

    /**
     * ID of the {@link Playlist} whose metadata is contained in the instance of this class.
     */
    private String id;

    /**
     * The {@link LocalDateTime} at which the download of the {@link Playlist} was started.
     */
    private LocalDateTime startedOn;

    /**
     * The {@link LocalDateTime} at which the download of the {@link Playlist} completed.
     */
    private LocalDateTime completedOn;

    /**
     * {@link List} of {@link PlaylistItemMeta} that was contained in the {@link Playlist} whose metadata is represented
     * by this class.
     */
    private List<PlaylistItemMeta> playlistItemsMeta;

}
