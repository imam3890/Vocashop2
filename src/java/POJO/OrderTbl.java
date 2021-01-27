package POJO;
// Generated Oct 24, 2020 11:57:52 AM by Hibernate Tools 4.3.1


import daos.DAO;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

/**
 * OrderTbl generated by hbm2java
 */
@ManagedBean
@SessionScoped
public class OrderTbl  implements java.io.Serializable {


     private Integer orderId;
     private int userId;
     private int vocId;
     private Integer vocCode;
     private Date date;
     private int vocPrice;
     private String payment;
     private String orderStatus;

    public OrderTbl() {
    }
    
    public OrderTbl(int orderId, int userId, int vocId, Integer vocCode, Date date, int vocPrice, String payment, String orderStatus) {
       this.userId = userId;
       this.vocId = vocId;
       this.vocCode = vocCode;
       this.date = date;
       this.vocPrice = vocPrice;
       this.payment = payment;
       this.orderStatus = orderStatus;
       this.orderId = orderId;
    }
   
    public Integer getOrderId() {
        return this.orderId;
    }
    
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
    public int getUserId() {
        return this.userId;
    }
    
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public int getVocId() {
        return this.vocId;
    }
    
    public void setVocId(int vocId) {
        this.vocId = vocId;
    }
    public Integer getVocCode() {
        return this.vocCode;
    }
    
    public void setVocCode(Integer vocCode) {
        this.vocCode = vocCode;
    }
    public Date getDate() {
        return this.date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    public int getVocPrice() {
        return this.vocPrice;
    }
    
    public void setVocPrice(int vocPrice) {
        this.vocPrice = vocPrice;
    }
    public String getPayment() {
        return this.payment;
    }
    
    public void setPayment(String payment) {
        this.payment = payment;
    }
    public String getOrderStatus() {
        return this.orderStatus;
    }
    
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
    
    public List<OrderTbl> getallrecords()
    {
        DAO pdao=new DAO();
        List<OrderTbl> prod=pdao.retrieveProduk();
        return prod;
    }
    
   public void saveVoc(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
        Date date = new Date();  
        Random rand = new Random();
        int rand1 = rand.nextInt(1000000000);
        setVocCode(rand1);
        setDate(date);
        setOrderStatus("SUCCESS");
        
        DAO pdao=new DAO();
        pdao.addOrder(this);
        
    }
     public void saveTop(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
        Date date = new Date();
        setDate(date);
        setOrderStatus("PENDING");
        
        DAO pdao=new DAO();
        pdao.addOrder(this);
        
    }
     public void delete()
    {    
        DAO pdao=new DAO();
        pdao.deleteOrder(orderId);
    }
     public void update()
    {
        OrdercancelTbl octb = new OrdercancelTbl();
        octb.setOrderId(orderId);
        octb.save();
        setOrderStatus("CANCEL PENDING");
        DAO pdao=new DAO();
        pdao.updateOrder(this);
    }
     public List<OrderTbl> getorderrecords(int user_id)
    {
        DAO pdao=new DAO();
        List<OrderTbl> prod=pdao.showOrder(user_id);
        return prod;
    }
     public List<OrderTbl> getbyid()
    { 
        DAO pdao=new DAO();
        List<OrderTbl> prod=pdao.getbyIDorder(orderId);
        userId=prod.get(0).userId;
        vocId=prod.get(0).vocId;
        vocCode=prod.get(0).vocCode;
        date=prod.get(0).date;
        vocPrice=prod.get(0).vocPrice;
        payment=prod.get(0).payment;
        orderStatus=prod.get(0).orderStatus;
        
        return prod;
    }
     public List<OrderTbl> getrecordbyid(int order_id)
    {
        DAO pdao=new DAO();
        List<OrderTbl> prod=pdao.showOrderbyid(order_id);
        return prod;
    }
     
     public void saveCancel()
    {
        OrdercancelTbl otb = new OrdercancelTbl();
        setOrderStatus("CANCELLED");
        DAO pdao=new DAO();
        pdao.updateOrder(this);
    }
     

}

