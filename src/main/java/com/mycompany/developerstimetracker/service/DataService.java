package com.mycompany.developerstimetracker.service;

import com.mycompany.developerstimetracker.dto.TimeTO;
import com.mycompany.developerstimetracker.dto.UserTO;
import com.mycompany.developerstimetracker.entity.Time;
import com.mycompany.developerstimetracker.entity.User;

/**
 * Created by AkimPC on 09.07.2016.
 */
public interface DataService {
    void convertToUserEntity(UserTO userTO);
    void convertToTimeEntity(TimeTO timeTO);
    User getConvertedUser();
    Time getConvertedTime();
}
