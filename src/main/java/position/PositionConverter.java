package position;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Converter(autoApply = true)
public class PositionConverter implements AttributeConverter<Position, String> {
	@Override
	public String convertToDatabaseColumn(Position attribute) {
		return attribute.toString();
	}

	@Override
	public Position convertToEntityAttribute(String dbData) {
		System.out.println(dbData);
		System.out.println(dbData.substring(1, dbData.indexOf(',')));
		System.out.println(dbData.substring(dbData.indexOf(',')+1, dbData.length()-1));
		return new Position(Integer.parseInt(dbData.substring(1, dbData.indexOf(','))), Integer.parseInt(dbData.substring(dbData.indexOf(',')+1, dbData.length()-1).trim()));
	}
}
