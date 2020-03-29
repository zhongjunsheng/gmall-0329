package member.center.com.api;

import member.center.com.pojo.Corn;

import java.util.List;

public interface CornService {

    List<Corn> getAllCorn();
    List<Corn> getCorn(Corn corn);
};
