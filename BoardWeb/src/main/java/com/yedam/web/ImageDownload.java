package com.yedam.web;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yedam.common.Control;

public class ImageDownload implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// [ {"src":"http","name":"헬리우스"},{},{}]
		ServletInputStream sis = req.getInputStream();
		ObjectMapper mapper = new ObjectMapper();
		List<Map<String, String>> list = mapper.readValue(sis, //
				new TypeReference<List<Map<String, String>>>() {
				});

		for (Map<String, String> map : list) {
			String src = map.get("src");
			String name = map.get("name");
			String[] str = name.split("/");
			String dir = str[0];
			name = str[1];

			System.out.println("src: " + src + ", dir: " + dir + ", name: " + name);
			System.out.println("-----------------------------");

		}
		System.out.println("end of prog.");

	}

	public void fileCreate(String src, String name) {
		URL url;
		try {
			url = new URL(src);

			InputStream is = null;
			OutputStream os = null;

			is = url.openStream();
			os = new FileOutputStream("c:/temp/" + name + ".jpg");

			while (true) {
				int data = is.read();
				if (data == -1) {
					break;
				}
				os.write(data);
			}
			is.close();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
