package main.model;

import jakarta.persistence.AttributeConverter;

/************************************************************/
/**
 * Converter for converting between the User entity and its corresponding
 * database column representation. This class implements the
 * {@link AttributeConverter} interface provided by JPA (Java Persistence API).
 * 
 * 
 * <p>This converter is used to convert the `User` object to a `String` (the username) 
 * when persisting to the database, and to convert a `String` (the username) back to a 
 * `User` object when reading from the database. The password is not stored or retrieved 
 * by this converter.</p>
 */
public class UserConverter implements AttributeConverter<User, String> {

	  /**
     * Converts a {@link User} entity to a {@link String} representing its username.
     * 
     * @param attribute the {@link User} object to convert
     * @return the username of the user as a {@link String}
     */
	@Override
	public String convertToDatabaseColumn(User attribute) {
		return attribute.getUsername();
	}

	 /**
     * Converts a {@link String} representing a username back to a {@link User} entity.
     * 
     * @param dbData the username as a {@link String} from the database
     * @return a {@link User} entity with the specified username
     */
	@Override
	public User convertToEntityAttribute(String dbData) {
		if (dbData == null || dbData.isEmpty()) {
			return null;
		}
		return new User(dbData,null);
	}

}
