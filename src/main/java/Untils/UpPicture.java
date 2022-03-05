package Untils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

public class UpPicture {
	public String Up(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		Part partPic = req.getPart("poster");
		String realPath = req.getServletContext().getRealPath("/imgs");
		String fileNamePic = Path.of(partPic.getSubmittedFileName()).getFileName().toString();
		if (!Files.exists(Path.of(realPath))) {
				Files.createDirectory(Path.of(realPath));
		}
		partPic.write(realPath+"/"+fileNamePic);
		return fileNamePic;
	}
}
