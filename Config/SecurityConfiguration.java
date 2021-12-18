package com.example.registrationLoginSecurityThymeleaf.Config;


import com.example.registrationLoginSecurityThymeleaf.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    /*
    Doğrulama, yetkilendirme, şifreleme ve diğer ayarların yapılması için
    WebSecurityConfigurerAdapter sınıfı kalıtım alınarak düzenlenir.
    Spring Security kullanıcı giriş işlemlerinin yanında farklı güvenlik
    Proje WebSecurityConfigurerAdapter sınıfında belirlenen varsayılan ayarlara göre çalışacak
    ve doğrulama sağlayıcısı(AuthenticationProvider) verilmediğinden giriş işleminde hata mesajı verecektir.
    yöntemlerini sağlamak için @EnableWebSecurity ifadesini kullanır.
     */


    /*
    Lazy için
   Hibernate’de iki nesneyi birbirine bağlamak için, iki yöntem kullanır.
   Bunlardan birincisi EAGER diğeri ise LAZY dir. Eğer EAGER kullanırsak nesneyi veritabanından çekerken
    EAGER olan tüm nesneleri de beraberinde çekeriz.
    Fakat LAZY kullanırsak, ihtiyaç duyduğumuzda ilgili veriler çekilecektir.

    Hibernate
    Hibernate yalnızca Java sınıflarından veritabanı tablolarına veya Java veri tiplerinde SQL veri tiplerine dönüşümü yapmaz.
     Hibernate veri sorgulama(data query) ve veri çekme(data retriaval) işlemlerini de kullanıcı için sağlar.
     Bu özellikleriyle Hibernate geliştirme kolaylığı ve zamandan kazanç sağlar.
     */
    @Lazy
    @Autowired  //@Autowired - Constructor, Değişken yada setter metodlar için dependency injection işlemi gerçekleştirir
    private UserService userService;
    /*
    @Autowired anotasyonu sayesinde bir bean içerisindeki değerleri başka beanin içerisine enjekte edebilir değerlerini
    koruyarak kullanabiliriz. @Autowired anotasyonunu bir değişken, setter ya da yapılandırıcı metot üzerinde kullanılabilmekteyiz.
     */

    @Bean //Bir metodun Spring tarafından yönetilen bir Bean ürettiğini belirtir
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider auth=new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        auth.setPasswordEncoder(passwordEncoder());
        return  auth;
        /*
        Provider dan kasıt, kullanıcı bilgilerinin getirileceği kaynaklara göre,
        <AuthenticationProvider> sınıfını implement eden sınıflara verilen isim diyebilir.
       Örneğin DB, ldap, oauth2 provider gibi düşünebiliriz.
        Bizim uygulamamız varsayılan ayarlarda DaoAuthenticationProvider kullanıyor.
      Bu sınıfta kullanıcı bilgileri çekmek için, <UserDetailsService> sınıfınının loadByUserName(..) methodunu çağırır.
         */
    }

    @Override
    protected  void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.authenticationProvider(authenticationProvider());
      //Authentication(kimlik doğrulama) ve Authorization(yetki kontrolu)

    }
    @Override
    protected  void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests().antMatchers(
                "/**",
                "/js/**",
                "/css/**",
                "/img/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout")
                .permitAll();


    }

}
