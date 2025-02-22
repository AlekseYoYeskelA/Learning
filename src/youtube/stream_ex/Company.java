package youtube.stream_ex;

import java.util.stream.Stream;

public interface Company {
    Stream<Department> departments();
}
