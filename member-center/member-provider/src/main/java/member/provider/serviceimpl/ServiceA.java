package member.provider.serviceimpl;

import org.springframework.stereotype.Service;

@Service
public class ServiceA {


    private ServiceB serviceB;

    public ServiceA setServiceB(ServiceB serviceB) {
        this.serviceB = serviceB;
        return this;
    }

    public static void main(String[] args) {

        new ServiceA();
    }
}
