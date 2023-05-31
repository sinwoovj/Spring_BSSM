package comclass34.bssm.hellospring34.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("/hello") //url에 매핑
    @ResponseBody //화면 자체에 뿌림
    public String hello(){
        return "hello";
    }

    @GetMapping("/hi")
    public String hi(){
        return "hi";
    }

    @GetMapping("/hi/data")
    public String hiData(Model model){
        model.addAttribute("name", "bssm");
        return "hiData";
    }

    @GetMapping("/hi/param")//      localhost:80/hi/param?data=mrchoi
    public String hiParam(@RequestParam("data") String data,
                          Model model) {
        model.addAttribute("name",data);
        return "hiData";
    }

    @GetMapping("/hello/param")
    @ResponseBody
    public String helloParam(@RequestParam("data") String data) // @RequestParam(어떤 이름의 파라미터로 받을 것인지) 자료형 변수명)
    {
        return "hello " + data;
    }

    // 객체 반환
    // 객체를 return 시키면 json 형태로 반환된다.
    @GetMapping("/hello/api")
    @ResponseBody
    public Person helloApi(@RequestParam("name") String name){
        Person person = new Person();
        person.setName(name);
        return person;
    }

    static class Person{ //static 인클래스 선언
        private String name;
        private int age;

        // Alt + Insert >> name과 age에 대한 Getter & Setter 생성
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}



    /*
    -데이터 레이어-
    Client -> Controller -> Service -> Repository(DAO) -> DB
          DTO           DTO         DTO             Domain(Enity)

    Client :
    Controller : 클라이언트와 통신을 하는 역할
    Service : buisiness 로직이 들어감 (예 필터? 기능)
    Repository : db의 값을 저장하고 수정함
    DB :

    src > main > resources > application.properties 에서 port번호 수정 가능

    * Side Rendering

    CSR : Client에서 Rnedering >> React, view.js
    = hello
    클라이언트에서 받은 정보를 자체적으로 보여줄 수 있도록 만듦.

    SSR : Server에서 Rendering >> thymeleaf(String boot)
    서버에서 만들어진 파일을 보냄
    = hi

    thymeleaf는 정적인 html을 동적으로 만들어 줌.
     */