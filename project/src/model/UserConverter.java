package model;

import jakarta.persistence.AttributeConverter;

public class UserConverter implements AttributeConverter<User, String> {

	@Override
	public String convertToDatabaseColumn(User attribute) {
		return attribute.getUsername();
	}

	@Override
	public User convertToEntityAttribute(String dbData) {
		if (dbData == null || dbData.isEmpty()) {
			return null;
		}
		return new User(dbData,null);
	}

}
