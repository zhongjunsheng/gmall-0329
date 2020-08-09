package member.center.com.api;

import member.center.com.pojo.School2;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoSchoolService extends MongoRepository<School2,String> {
}
