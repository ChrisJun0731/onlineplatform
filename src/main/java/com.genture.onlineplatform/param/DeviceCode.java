package com.genture.onlineplatform.param;

/**
 * Created by Administrator on 2018/7/27.
 */
public class DeviceCode {

	//省路网编码（行政区编码，前两位）
	private String provinceCode;
	//省路段编码
	private String roadCode;
	//监控中心编码
	private String departmentCode;
	//设备类型编码
	private String deviceTypeCode;
	//设备数量编码
	private String deviceNumCode;

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public String getRoadCode() {
		return roadCode;
	}

	public void setRoadCode(String roadCode) {
		this.roadCode = roadCode;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	public String getDeviceTypeCode() {
		return deviceTypeCode;
	}

	public void setDeviceTypeCode(String deviceTypeCode) {
		this.deviceTypeCode = deviceTypeCode;
	}

	public String getDeviceNumCode() {
		return deviceNumCode;
	}

	public void setDeviceNumCode(String deviceNumCode) {
		this.deviceNumCode = deviceNumCode;
	}

	/**
	 * 将一个字符串解析为DeviceCode对象
	 * @param deviceId
	 * @return
	 */
	public static DeviceCode parseDeviceCode(String deviceId){

		DeviceCode deviceCode = new DeviceCode();

		if (deviceId.length() != 12) {
			System.out.println("设备的编码长度不符合规范！(设备编码长度12)");
			return null;
		} else {
			String provinceCode = deviceId.substring(2,4);
			String roadCode = deviceId.substring(4,6);
			String departmentCode = deviceId.substring(6, 8);
			String deviceTypeCode = deviceId.substring(8, 10);
			String deviceNumCode = deviceId.substring(10, 12);

			deviceCode.setProvinceCode(provinceCode);
			deviceCode.setRoadCode(roadCode);
			deviceCode.setDepartmentCode(departmentCode);
			deviceCode.setDeviceTypeCode(deviceTypeCode);
			deviceCode.setDeviceNumCode(deviceNumCode);
			return deviceCode;
		}
	}

	@Override
	public String toString(){
		return "0x" + provinceCode + roadCode + departmentCode + deviceTypeCode + deviceNumCode;
	}
}
