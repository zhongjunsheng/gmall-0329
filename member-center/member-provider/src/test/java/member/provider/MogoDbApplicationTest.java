package member.provider;

import com.alibaba.fastjson.JSON;
import member.center.com.pojo.School2;
import member.center.com.pojo.Student;
import member.provider.serviceImpl.MongoDbService;
import member.provider.serviceImpl.MongoSchoolService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MogoDbApplicationTest {

    @Autowired
    private MongoDbService mongoDbService;  //student 表/collection
    @Autowired
    private MongoSchoolService mongoSchoolService;  //school 表/collection



    @Test
    public void mongoDbUsergetAll(){
        //mongoDb的collection名称必须是student或者Student
        List<School2> all = mongoSchoolService.findAll();
        System.out.println("所有记录是:"+all);
    }


    /**
     * 创建分页请求.
     */
    private PageRequest buildPageRequest(int pageNumber, int pageSize,String sortType) {
        Sort sort = null;
        if ("id".equals(sortType)) {
            sort = new Sort(Sort.Direction.DESC, "_id");
        } else if ("age".equals(sortType)) {
            //根据年龄降序
            sort = new Sort(Sort.Direction.ASC, "age");
        }
        //参数1表示当前第几页,参数2表示每页的大小,参数3表示排序
        return new PageRequest(pageNumber-1,pageSize,sort);
    }


    //新增和update是一回事都是掉save()
    @Test
    public void add(){
        Student stu = new Student("7","zhongjunsheng",37);
        Student save = mongoDbService.save(stu);
        System.out.println(save);
    }

    //分页查询
    @Test
    public  void getPage(){
       //构建分页信息
        //PageRequest pageRequest = buildPageRequest(2,2,"age");
        PageRequest pageRequest = buildPageRequest(2,2,null); //五排序
        //查询指定分页的内容
        Page<Student> all = mongoDbService.findAll(pageRequest);
        System.out.println(all.getTotalElements());
        System.out.println(all.getTotalPages());
        List<Student> content = all.getContent();
        System.out.println(JSON.toJSON(all));
        System.out.println(content);

    }



    @Test
    public void getAll(){
        //mongoDb的collection名称必须是student或者Student
        List<Student> all = mongoDbService.findAll();
        System.out.println("所有记录是:"+all);
    }

    @Test
    public void getById(){
        //mongoDb的collection名称必须是student或者Student
        Optional<Student> result = mongoDbService.findById("2");
        Student student = result.get();
        System.out.println("所有记录是:"+student);
    }

    @Test
    public void getByName(){
        //mongoDb的collection名称必须是student或者Student
        List<Student> allen = mongoDbService.findByName("allen");
        System.out.println("所有记录是:"+allen);
    }

    @Test
    public void getByAge(){
        //mongoDb的collection名称必须是student或者Student
        List<Student> allen = mongoDbService.findByAgeLessThanEqual(30);
        System.out.println("所有记录是:"+allen);
    }
    @Test
    public void getByAgeBetween(){
        //mongoDb的collection名称必须是student或者Student
        List<Student> allen = mongoDbService.findByAgeBetween(30,40);
        System.out.println("所有记录是:"+allen);
    }


    @Test
    public void getNameLike(){
        //mongoDb的collection名称必须是student或者Student
        List<Student> allen = mongoDbService.findByNameLike("allen");
        System.out.println("所有记录是:"+allen);
    }

    //跟新
    @Test
    public void update(){
        Student stu = new Student("7","zhongjunsheng7",37);
        Student save = mongoDbService.save(stu);
        System.out.println(save);
    }

    //删除
    @Test
    public void del(){
        Student stu = new Student("7","zhongjunsheng",20);
        //mongoDbService.delete(stu);
        mongoDbService.deleteById("7");
    }
}


