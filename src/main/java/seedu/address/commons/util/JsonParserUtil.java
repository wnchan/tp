package seedu.address.commons.util;

import java.io.IOException;
import seedu.address.model.AddressBook;

public class JsonParserUtil {

    public static AddressBook parseJsonToAddressBook(String jsonString) throws IOException {
        try {
            return JsonUtil.fromJsonString(jsonString, AddressBook.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
