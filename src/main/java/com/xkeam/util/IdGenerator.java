package com.xkeam.util;



public class IdGenerator {
	
	private static final String ID_SPACE = "haystack:directory:id"; 
	private static final String LOGICAL_ID = "logicalId";
	private static final String NEEDLE_ID = "needleId";
	private static final String STORE_ID = "storeId";
	
	public static final String SEPARATOR = ":";
	
	
	public static synchronized long genLogicalId() {
		return RedisStore.incrAndGet(ID_SPACE, LOGICAL_ID);
	}
	
	public static synchronized long genNeedleId() {
		return RedisStore.incrAndGet(ID_SPACE, NEEDLE_ID);
	}
	
	public static synchronized long genStoreId() {
		return RedisStore.incrAndGet(ID_SPACE, STORE_ID);
	}
	
	public static String fullId(String parentId, String childId) {
		return parentId + SEPARATOR + childId;
	}
	
	public static String[] parseFullId(String fullId) {
		String[] split = fullId.split(SEPARATOR);
		
		return split;
	}

	

}
