package know.how.core.annotation;

import java.lang.annotation.Documented;

@ClassPreamble (
   author = "John Doe",
   date = "3/17/2002",
   currentRevision = 6,
   lastModified = "4/12/2004",
   lastModifiedBy = "Jane Doe",
   // Note array notation
   reviewers = {"Alice", "Bob", "Cindy"}
)

public class Metatags 
{
	@UserInfo (name = "janek")
	String person;
}

@Documented
@interface ClassPreamble {
   String author();
   String date();
   int currentRevision() default 1;
   String lastModified() default "N/A";
   String lastModifiedBy() default "N/A";
   // Note use of array
   String[] reviewers();
}

@interface UserInfo {
	String name();
	String surname() default "peter";
	int salary() default 10000;
}

