package main;

import config.AppCtx;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.ChangePasswordService;
import spring.MemberNotFoundException;
import spring.WrongIdPasswordException;

public class MainForCPS {

    public static void main(String[] args){
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);

        ChangePasswordService cps = ctx.getBean("changePwdSvc", ChangePasswordService.class);

        try {
            cps.changePassword("0307174951@test.com", "0307174951", "1234");
            System.out.println("암호 변경");
        } catch (MemberNotFoundException e) {
            System.out.println("회원 X");
        } catch (WrongIdPasswordException e){
            System.out.println("비밀번호 X");
        }

        ctx.close();
    }
}
