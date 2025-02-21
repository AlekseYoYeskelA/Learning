package stream_api.client;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

public enum GenderType {
    MALE("Мужской"),
    FEMALE("Женский");

    private final String GENDER_TYPE;

    //В перечислениях конструктор приватный по умолчанию
    GenderType(String genderType) {
        this.GENDER_TYPE = genderType;
    }

    public String getGenderType() {
        return GENDER_TYPE;
    }
}





class Human {
    private GenderType gender;

    public Human(String gender) {
        this.setGender(gender);
    }

    public GenderType getGender() {
        return gender;
    }


    private void setGender(String gender) {
        final String MALE = "Мужской";
        final String FEMALE = "Женский";
        if (gender.equalsIgnoreCase(MALE)) {
            this.gender = GenderType.MALE;
        } else if (gender.equalsIgnoreCase(FEMALE)) {
            this.gender = GenderType.FEMALE;
        } else {
            throw new IllegalArgumentException("WAT?");
        }
    }

    @Override
    public String toString() {
        return "Human{" +
                "gender='" + gender + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Human human = new Human("мужской");
        System.out.println(human);


    }
}

