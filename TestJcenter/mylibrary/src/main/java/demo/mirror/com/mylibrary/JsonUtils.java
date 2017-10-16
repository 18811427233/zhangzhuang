package demo.mirror.com.mylibrary;

import com.alibaba.fastjson.JSON;

/**
 * JSON工具类
 * 
 * <pre>
 * 使用阿里巴巴提供的FASTJSON实现
 * </pre>
 * <ul>
 * <strong>处理JSON</strong>
 * <li>转换JSON字符串 {@link #toJSONString(Object)}</li>
 * <li>解析JSON字符串 {@link #parseObject(String, Class)}</li>
 * </ul>
 */
public class JsonUtils {

	private JsonUtils() {
		throw new AssertionError();
	}

	/**
	 * 对象转换JSON文本
	 * 
	 * @param object
	 * @return
	 */
	public static final String toJSONString(Object object) {
		try {
			return JSON.toJSONString(object);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	/**
	 * JSON文本转换对象
	 * 
	 * @param text
	 * @param clazz
	 * @return
	 */
	public static final <T> T parseObject(String text, Class<T> clazz) {
		try {
			return JSON.parseObject(text, clazz);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
