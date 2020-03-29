package member.provider.Java8Test;

public class MyTest {
	
	/*private static  int a = 10;
    public static void main(String[] args) {
    	
    	
        List<String> a1 = Arrays.asList("a", "b", "c");

        for (String a : a1) {
            printValur(a);
        };

        //1
        a1.forEach(x -> MyTest.printValur(x));
        //下面的执行结果和上面一样
        a1.forEach(MyTest::printValur);
        
        
        System.out.println("#############################");
        
        
        List<String> list = a1.stream().map(x -> x.toUpperCase()).collect(Collectors.toList());
        System.out.println(list.toString());
        
        ArrayList<String> collect = a1.stream().map(String::toUpperCase).collect(Collectors.toCollection(ArrayList::new));
        System.out.println(collect.toString());
        
        User user1 = new User(1,"aa",null,null) ;
        User user2 = new User(2,"bb",null,null) ;
        User user3 = new User(3,"cc",null,null) ;
        List<User> lt = new ArrayList<>();
        lt.add(user1);
        lt.add(user2);
        lt.add(user3);
        
        Map<Integer, String> map  = lt.stream().collect(Collectors.toMap(key -> key.getId(), value -> value.getName()));
        Map<Integer, String> map2  = lt.stream().collect(Collectors.toMap(User::getId, User::getName));
        
        
		Map<Integer, User> mapp = lt.stream().collect(Collectors.toMap(User::getId, Function.identity()));

        
        System.out.println(map.entrySet().toString());
        System.out.println(map.get(1));
        System.out.println(map2.get(1));
        System.out.println(mapp);
        System.out.println(mapp.get(1).getName());
        
        ExecutorService servcie = Executors.newCachedThreadPool();
        servcie.execute(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		});
        
        servcie.execute(() -> System.out.println("bb"));
        Future<?> submit = servcie.submit(() -> System.out.println("aa"));
        
        
        


    }

    public static void printValur(String str) {
        System.out.println("print value : " + str);
    }
}*/
}