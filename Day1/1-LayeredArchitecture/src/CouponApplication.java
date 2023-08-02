import com.walmart.api.coupon.dao.CouponDao;
import com.walmart.api.coupon.dao.impl.CouponJpaDaoImpl;
import com.walmart.api.coupon.model.Coupon;

public class CouponApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("In Coupon application");
		Coupon coupon = new Coupon();
		
		coupon.setCouponCode("c1");
		coupon.setDiscount(100);
		coupon.setId("1");
		
		CouponDao couponDao = new CouponJpaDaoImpl(); // Here we are creating object and hence application class is tightly coupled with CouponJpaDaoImpl
		//If you plan to switch to JDBC, this line needs to be changed, which is classical example of tight coupling
		//In java application it is very common that two layers are talking to each other which leads to tight coupling problem.
		//To exactly solve this problem, spring was born
		couponDao.saveCoupon(coupon);
		
		
		
	}

}
