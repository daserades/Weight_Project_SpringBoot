package com.example.registrationLoginSecurityThymeleaf.Model;

import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="user",uniqueConstraints = @UniqueConstraint(columnNames = "email" ))
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    private String email;

    private String password;


    /*
     Çoka çok ilişki @ManyToMany
     BAŞKA BİR ÖRNEK İÇİN
     Çoka çok ilişkiyi kitapların birden fazla yazarı olacağı gibi yazarlarında birden fazla kitabı olabilir
     bu @ManyToMany ilişkisinin persist sınfını  bir liste olarak kitap sınıfında tanımlıyoruz.
     Bu yapı ile birlikte JoinTable yaparak diğer bir tabloda kitap_id ve yazar_id  bilgilerinin tutulduğu yazar_kitap
     tablosunda tutulmaktadır.
     */



    /*
    Cascade nedir?

 Cascade, bir JPA standardıdır. Entity sınıflarımızdaki ilişkilerin hareketlerini yani davranışlarını cascade tipleri
 ile ayarlarız. Yani ilişkili sınıfların birbirlerinden etkilenip etkilenmemesini sağlıyor.
  Örnek olarak bir değer sildiğimizde o silinen veri ilişkili olan verilerin etkilenmesini ya da
  etkilenmemesini sağlarız. Bu JPA standartı, veritabanımıza bulaşmadan kolaylıkla Java sınıflarımız üzerinden
  işlemleri yönetmemizi sağlar.
  All --> Tüm işlemleri ilişkili nesnelerle birlikte yapar

  Fetch Type Nedir?
Aralarında ilişki bulunan Entity sınıflarından bir tarafın yüklenme durumunda diğer tarafın yüklenme stratejisini belirlememizi sağlar.
Hibernate de 2 adet fetch type vardır. Bunlar:

1-)Eager(Ön Yükleme)
2-)Lazy(Tembel/Sonradan Yükleme)

Eğer @OneToOne ve @ManyToOne ilişkileri kullanıyorsak FetchType olarak Eager kullanmamız daha doğru olur.
Yani bir tane Entity nesnesi üzerinden ilişki kurulduğundan ön yükleme yapmak performans açısından sorun oluşturmaz.

Eğer ki @OneToMany ve @ManyToMany ilişki kullanıyorsak FetchType olarak Lazy kullanmamız daha doğru olur.
Yani birden fazla ilişkili nesne olduğundan ön yükleme yapmamız performans açısından kayba neden olur.


 Bunun için ihtiyaç duyulduğunda yüklemek daha doğru olur.

 Cascade Tiplerini Açıklayalım.

PERSIST
İlişki persist olarak tanımlandıysa kaydedilen nesnenin alt nesneside kaydedilir.

MERGE
İlişki merge olarak tanımlandıysa nesne merge edilirse ilişkili olan nesne de merge edilir.

REMOVE
İlişki remove olarak tanımlandıysa nesne silinirse ilişkili olan nesne de silinir.

REFRESH
İlişki refresh olarak tanımlandıysa nesne yenilenirse bağlı olan nesne de yenilenir.

ALL
İlişki all olarak tanımlandıysa yukarıdaki tüm işlemler için birlikte yapılır.
     */
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))

    private Collection<Role> roles;

    public User() {

    }

    public User(String firstName, String lastName, String email, String password, Collection<Role> roles) {

        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }
}