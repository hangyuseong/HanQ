package DAO_Ex;

import java.io.Serializable;
import java.sql.Date;

public class Good implements Serializable{ // 데이터들을 저장하여 객체화한것 DTO

   private String code;
   private String name;
   private String manufacture;
   private int price;
   private Date makingdate;
   
   
   public Good()
   {
      super();
   }
   
   public Good(String code, String name, String manufacture, int price, Date makingdate)
   {
      this.code = code;
      this.name = name;
      this.manufacture = manufacture;
      this.price = price;
      this.makingdate = makingdate;   
   }

   public String getCode() {
      return code;
   }

   public void setCode(String code) {
      this.code = code;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getManufacture() {
      return manufacture;
   }

   public void setManufacture(String manufacture) {
      this.manufacture = manufacture;
   }

   public int getPrice() {
      return price;
   }

   public void setPrice(int price) {
      this.price = price;
   }

   public Date getMakingdate() {
      return makingdate;
   }

   public void setMakingdate(Date makingdate) {
      this.makingdate = makingdate;
   }
   
   @Override
   public String toString() {

      return "Good [code=" + code + ", name=" + name + ", manufacture="
             + manufacture + ", price=" + price + ", makingdate="
             + makingdate + "]";
   }
}