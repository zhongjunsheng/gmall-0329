package member.provider.serviceimpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceB {

    private ServiceA serviceA;

    public ServiceB setServiceA(ServiceA serviceA) {
        this.serviceA = serviceA;
        return this;
    }
}


