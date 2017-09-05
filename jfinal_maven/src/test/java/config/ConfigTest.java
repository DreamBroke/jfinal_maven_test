package config;

import junit.framework.TestCase;

import org.junit.Test;

import com.jfinal.plugin.activerecord.Db;

public class ConfigTest extends TestCase{

    @Test
    public void test() {
        assertNotNull(Db.find("select * from commodity"));
    }
    
}
