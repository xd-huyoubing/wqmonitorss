/**
 * <p>Title: Test.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>University: xidian.edu</p>
 * @author 胡有兵
 * @date 2017年11月11日下午8:25:07
 * @version 1.0
 */
package xidian.edu.wqminotor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.junit.Test;

import cmcc.iot.onenet.javasdk.api.datapoints.AddDatapointsApi;
import cmcc.iot.onenet.javasdk.api.datastreams.AddDatastreamsApi;
import cmcc.iot.onenet.javasdk.api.datastreams.DeleteDatastreamsApi;
import cmcc.iot.onenet.javasdk.model.Data;
import cmcc.iot.onenet.javasdk.model.Datapoints;
import cmcc.iot.onenet.javasdk.response.BasicResponse;
import cmcc.iot.onenet.javasdk.response.datastreams.NewdatastramsResponse;

/**
 * <p>
 * Title: Test
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * University: xidian.edu
 * </p>
 * 
 * @author 胡有兵
 * @date 2017年11月11日下午8:25:07
 * @version 1.0
 */
public class TestApp {

	@Test
	public void testAddDatastreamsApi() {
		String key = "1etHd9SqAENVLjmKuYJy9HjtyVs=";
		String id = "temperature4";
		String devId = "20389602";
		List<String> tags = new ArrayList<String>();
		tags.add("china");
		tags.add("mobile");
		String unit = "celsius";
		String unitsymbol = "C";
		String cmd = "0003000000184411";
		int interval = 60;
		String formula = "(A0+A1)*A2";
		/**
		 * 数据流新增
		 * @param id：数据流名称 ，String
		 * @param devId:设备ID,String
		 * @param tags:数据流标签（可选，可以为一个或多个）,List<Stirng>
		 * @param unit:单位（可选）,String
		 * @param unitSymbol:单位符号（可选）,String
		 * @param cmd:MODBUS设备填写，周期下发命令，16进制字节字符串
		 * @param interval:MODBUS设备填写，采集间隔，秒,Integer
		 * @param formula:MODBUS设备填写，寄存器计算公式（可选）,String
		 * @param key:masterkey 或者 设备apikey
		 */
		AddDatastreamsApi api = new AddDatastreamsApi(id, devId, tags, unit, unitsymbol, cmd, interval, formula, key);
		BasicResponse<NewdatastramsResponse> response = api.executeApi();
		System.out.println("errno:"+response.errno+" error:"+response.error);
		System.out.println(response.getData().id);
	}
	
	@Test
	public void TestAppasaa() throws ParseException {
		while (true) {
			Date currentTime = new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time = format.format(currentTime);
			time = time.replaceAll(" ", "T");
			System.out.println(time);

		}

	}

	@Test
	public void testRemoveDatastreamApi() {
		String dsid = "test";
		String key = "1etHd9SqAENVLjmKuYJy9HjtyVs=";
		String devId = "20389602";
		/**
		 * 数据流删除
		 * 
		 * @param devid:设备ID,String
		 * @param datastreamid:数据流名称
		 *            ,String
		 * @param key:masterkey
		 *            或者 设备apikey
		 */
		DeleteDatastreamsApi api = new DeleteDatastreamsApi(devId, dsid, key);
		BasicResponse<Void> response = api.executeApi();
		System.out.println("errno:" + response.errno + " error:" + response.error);
	}

	/**
	 * <p>
	 * Title:
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void testAddDatapointsApi() throws InterruptedException {
		String devid = "20389602";
		String key = "1etHd9SqAENVLjmKuYJy9HjtyVs=";
		List<Datapoints> list = new ArrayList<Datapoints>();
		List<Data> dl = new ArrayList<Data>();

		
			Random random = new Random();

			Date currentTime = new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time = format.format(currentTime);
			time = time.replaceAll(" ", "T");

			int dataKey = random.nextInt(10000);

			dl.add(new Data(time, dataKey));
			// dl.add(new Data("2016-10-22T00:36:43", 12));
			list.add(new Datapoints("temperature4", dl));
			// list.add(new Datapoints("datastream_idxy", dl));
			Map<String, List<Datapoints>> map = new HashMap<String, List<Datapoints>>();
			map.put("datastreams", list);
			/**
			 * 数据点新增
			 * 
			 * @param map
			 *            :数据点内容,Map<String,List<Datapoints>>
			 * @param data:提供简写方式上传数据,String
			 *            示例： type=4
			 *            data="{\"temperature\":{\"2015-03-22T22:31:12\":22.5}}"; type=5
			 *            data=",;temperature,2015-03-22T22:31:12,22.5;pm2.5,89";
			 * @param type:上传数据类型（可选，默认为完整JSON型，见HTTP内容示例）
			 * @param devId:设备ID,String
			 * @param key:masterkey
			 *            或者 设备apikey
			 */
			AddDatapointsApi api = new AddDatapointsApi(map, null, null, devid, key);

			BasicResponse<Void> response = api.executeApi();
			System.out.println(dataKey + "   " + "errno:" + response.errno + " error:" + response.error);
		}


}
