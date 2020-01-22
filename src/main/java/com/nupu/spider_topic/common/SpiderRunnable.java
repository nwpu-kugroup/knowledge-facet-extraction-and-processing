package com.nupu.spider_topic.common;

import com.nupu.domain.domain.Domain;
import com.nupu.utils.Log;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import static com.nupu.spider_topic.service.TSpiderService.constructKGByDomainName;

public class SpiderRunnable implements Runnable {
    private Domain domain;

    public SpiderRunnable(Domain domain) {
        this.domain = domain;
    }

    @Override
    public void run(){
        try {
            constructKGByDomainName(this.domain);
        }
        catch (Exception e){
            Log.log(""+e.toString());
        }
    }

}

