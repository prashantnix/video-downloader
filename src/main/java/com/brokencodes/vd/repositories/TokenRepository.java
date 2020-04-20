package com.brokencodes.vd.repositories;

import com.brokencodes.vd.beans.ydl.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<Token, Long> {

}
