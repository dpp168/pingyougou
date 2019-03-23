package cn.itcast.core.controller.upload;

import cn.itcast.core.utils.fdfs.FastDFSClient;
import cn.itcast.utilsBean.Result;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传类
 */
@RestController
@RequestMapping("/upload")
public class FileUploadController {

    @Value("${FILE_SERVER_URL}")
    private String FASTDFS_SERVER_URL;

    @RequestMapping("/uploadFile.do")
    public Result fileUpload(MultipartFile file){
        try {
            String conf = "classpath:fastDFS/fdfs_client.conf";
            FastDFSClient fsatDFSClient = new FastDFSClient(conf);
            //获取文件扩展名
            String FileName = file.getOriginalFilename();
            String extName = FilenameUtils.getExtension(FileName);
            String path = fsatDFSClient.uploadFile(file.getBytes(), extName, null);
            String url = FASTDFS_SERVER_URL +path;
            return new Result(true,url);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"上传失败");
        }
    }
}
