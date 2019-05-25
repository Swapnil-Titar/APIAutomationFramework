package resources;

public class JIRAPayload 
{

	public static String JIRAProjectCreationPayload()
	{
		
		String Bo="{    \"key\": \"EX1111\",\r\n" + 
				"    \"name\": \"Example11\",\r\n" + 
				"    \"projectTypeKey\": \"business\",\r\n" + 
				"    \"projectTemplateKey\": \"com.atlassian.jira-core-project-templates:jira-core-project-management\",\r\n" + 
				"    \"description\": \"Example Project description\",\r\n" + 
				"    \"lead\": \"ankurj\",\r\n" + 
				"    \"url\": \"http://atlassian.com\",\r\n" + 
				"    \"assigneeType\": \"PROJECT_LEAD\",\r\n" + 
				"    \"avatarId\": 10200\r\n" + 
				"  }";

		return Bo;
		
		}
	
	public static String JIRAProjectUpdatePayload()
	{
		
		String DelBo="{\r\n" + 
				"    \"key\": \"EX1111\",\r\n" + 
				"    \"name\": \"Example11\",\r\n" + 
				"    \"projectTypeKey\": \"Software\",\r\n" + 
				"    \"projectTemplateKey\": \"com.atlassian.jira-core-project-templates:jira-core-project-management\",\r\n" + 
				"    \"description\": \"Example Project description\",\r\n" + 
				"    \"lead\": \"ankurj\",\r\n" + 
				"    \"url\": \"\",\r\n" + 
				"    \"assigneeType\": \"PROJECT_LEAD\",\r\n" + 
				"    \"avatarId\": 10200\r\n" + 
				"  \r\n" + 
				"  \r\n" + 
				"}";
		
		return DelBo;
		
	}
	
	public static String CreateIssuePayload()
	{
		String CreateBug="{\r\n" + 
				"      \"fields\": {\r\n" + 
				"        \"project\": {\r\n" + 
				"            \"key\": \"SEC\"\r\n" + 
				"        },\r\n" + 
				"        \"summary\": \"New Test Bug\",\r\n" + 
				"       \"description\": \"Test description for bugs\",\r\n" + 
				"       \"issuetype\":{\r\n" + 
				"       	\"name\":\"Bug\"\r\n" + 
				"       }\r\n" + 
				"          }\r\n" + 
				"}";
		
		return CreateBug;
		
	}
	
	public static String AssignIssuePayload()
	{
		String Assign="{\r\n" + 
				"    \"name\": \"ankurj\"\r\n" + 
				"}";
		
		return Assign;
		
	}
	
	public static String CreateCommentPayload()
	{
		String Comment="{\r\n" + 
				"    \"body\": \"Defect Fixed1\",\r\n" + 
				"    \"visibility\": {\r\n" + 
				"        \"type\": \"role\",\r\n" + 
				"        \"value\": \"Administrators\"\r\n" + 
				"    }\r\n" + 
				"}";
		
		return Comment;
		
		
	}
	
	public static String updateCommentPayload()
	{
			String Comment="{\r\n" + 
					"    \"body\": \"Defect Fixed1\",\r\n" + 
					"    \"visibility\": {\r\n" + 
					"        \"type\": \"role\",\r\n" + 
					"        \"value\": \"Administrators\"\r\n" + 
					"    }\r\n" + 
					"}";
			
			return Comment;
			
			
		}
	
	public static String AddWatcherPayload()
	{
		String Addwatcher="\"ankurj\"";
		
		return Addwatcher;
		
	}
	
	
		
	}
	
	
	
	

