package cn.melancholy;

import cn.melancholy.config.WxConfigure;
import cn.melancholy.util.HttpClientUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Unit test for simple App.
 */
@SpringBootTest(classes = PartnerPushApp.class)
@RunWith(SpringRunner.class)
public class AppTest 
{
    @Autowired
    private WxConfigure wxConfigure;
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        System.out.println(wxConfigure.getApp_id());
    }

    @Test
    public void requestTest() throws Exception {
        String s = HttpClientUtils.doGet("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx2841260659a85996&secret=787d741294fed53a2d667171b6c5bfaa", null);
        System.out.println(s);
    }
    @Test
    public void jsonChangeObject(){
        String json  = "{\"access_token\":\"60_3ZKaTzk3O-77JWHd5XvQV2VDIRLAhfl3ZnZaGMC-De1drPnEfVprR8pw9glFOVMXPzSWXr5jYqtmQaArCs4Ow9rXpJ1dB73OJ1vzDHntW_fvXOYQu1ekBxJ-zTKk8q_o7oUdYt5tr55o1jlZBZXhAFAKIG\",\"expires_in\":7200}";
        JSONObject jsonObject = JSON.parseObject(json);
        System.out.println(jsonObject.get("access_token"));
    }
}
