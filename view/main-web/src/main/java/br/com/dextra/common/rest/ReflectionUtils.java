package br.com.dextra.common.rest;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class ReflectionUtils {

	private ReflectionUtils() {
		super();
	}

	public static void setField(String fieldName, Object target,
			Object newfieldValue) {
		try {
			Field declaredField = findField(target.getClass(), fieldName);
			declaredField.setAccessible(true);
			declaredField.set(target, newfieldValue);
		} catch (SecurityException e) {
			throw new RuntimeException(e);
		} catch (NoSuchFieldException e) {
			throw new RuntimeException(e);
		} catch (IllegalArgumentException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}

	public static boolean isSubclass(Class<?> clazz, Class<?> suposedSuperclass) {
		Class<?> sclass = clazz.getSuperclass();
		do {
			if (sclass != null) {
				if (sclass.equals(suposedSuperclass)) {
					return true;
				}
				sclass = sclass.getSuperclass();
			}
		} while (sclass != null);

		return false;
	}

	public static Field findField(Class<?> clazz, String fieldName)
			throws NoSuchFieldException {
		Field field;
		try {
			field = clazz.getDeclaredField(fieldName);
		} catch (SecurityException e) {
			throw new RuntimeException(e);
		} catch (NoSuchFieldException e) {
			if (clazz.getSuperclass() == null) {
				throw e;
			}
			field = findField(clazz.getSuperclass(), fieldName);
		}
		return field;
	}

	public static Method findMethod(Class<?> clazz, String methodName)
			throws NoSuchMethodException {
		Class<?>[] params = new Class[0];
		Method method;
		try {
			method = clazz.getDeclaredMethod(methodName, params);
		} catch (SecurityException e) {
			throw new RuntimeException(e);
		} catch (NoSuchMethodException e) {
			if (clazz.getSuperclass() == null) {
				throw e;
			}
			method = findMethod(clazz.getSuperclass(), methodName);
		}
		return method;
	}

	public static List<Field> getFieldsFromClassAndSuperclasses(Class<?> clazz) {
		List<Field> fields = new ArrayList<Field>();

		fields.addAll(Arrays.asList(clazz.getDeclaredFields()));

		Class<?> superClass = clazz.getSuperclass();

		while (superClass != null) {
			fields.addAll(Arrays.asList(superClass.getDeclaredFields()));
			superClass = superClass.getSuperclass();
		}

		return fields;
	}
}
