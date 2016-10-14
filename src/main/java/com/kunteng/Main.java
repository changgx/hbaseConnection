package com.kunteng;/**
 * Created by Administrator on 2016/10/12.
 */

import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.Scan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.hadoop.hbase.HbaseTemplate;
import org.springframework.data.hadoop.hbase.RowMapper;

/**
 * Administrator 2016/10/12
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext act=new ClassPathXmlApplicationContext("classpath:spring-hbase.xml");
        HbaseTemplate hbaseTemplate=(HbaseTemplate)act.getBean("hbaseTemplate");
        Scan scan = new Scan();
        scan.setStartRow("000000000000-0R1".getBytes());
        scan.setStopRow("000000000000-5A9".getBytes());
        hbaseTemplate.find("yunac_oldCustomer", scan, new RowMapper<String>() {
            public String mapRow(Result result, int rowNum) throws Exception {
                String rowkey = new String(result.getRow());
                System.out.println(rowkey);
                return null;
            }
        });
    }
}
