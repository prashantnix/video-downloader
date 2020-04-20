package com.brokencodes.vd.beans.users;

import com.brokencodes.vd.beans.ydl.Device;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

public class AccessHistory {

    @Id
    @GeneratedValue
    private Long id;

    private User user;

    private LocalDateTime loginTime;

    private LocalDateTime logoutTime;

    private LocalDateTime lastAccessedTime;

    private Device device;

    private String ipAddress;
}
