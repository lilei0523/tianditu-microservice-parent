package com..chinamobile.demo.microservice.util.feign.andfamily.inside;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * 
 * @ClassName: DeviceFeignParentService
 * @Description: 设备微服务feign接口父类
 * @author: zhangli
 * @date:2018年6月28日 下午8:12:21
 */
public interface DeviceFeignParentService {
	/**
	 * 
	 * @Title: queryDeviceInfoByDeviceSn @Description:
	 * 通过deviceSn获取设备信息 @param @param inparams @param @return @return String @throws
	 */
	@RequestMapping(value = "/device/query-device-info-by-device-sn", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
	String queryDeviceInfoByDeviceSn(String inparams);

	/**
	 * 
	 * @Title: modifyDeviceInfoByDeviceMacAddress @Description:
	 * 通过物理地址修改设备信息 @param @param inparams @param @return @return String @throws
	 */
	@RequestMapping(value = "/device/modify-device-info-by-device-mac-address", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
	String modifyDeviceInfoByDeviceMacAddress(String inparams);

	/**
	 * 
	 * @Title: queryAllDeviceInfo @Description: 获取所有设备信息列表 @param @param
	 * inparams @param @return @return String @throws
	 */
	@RequestMapping(value = "/device/query-all-device-info", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
	String queryAllDeviceInfo(String inparams);

	/**
	 * 
	 * @Title: queryUserDeviceByDeviceId @Description: TODO @param @param
	 * deviceId @param @return @return String @throws
	 */
	@RequestMapping(value = "/device/query-user-device-by-device-id", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
	String queryUserDeviceByDeviceId(Integer deviceId);


}
