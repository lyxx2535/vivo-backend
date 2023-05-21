package com.example.vivo_backend.entity.filepath.factory;

import com.example.vivo_backend.constant.FileType;
import com.example.vivo_backend.entity.filepath.strategy.FilePath;
import com.example.vivo_backend.entity.filepath.strategy.ReportPath;
import com.example.vivo_backend.entity.filepath.strategy.ReviewPicPath;
import com.example.vivo_backend.exception.BadRequestException;
import org.springframework.beans.factory.annotation.Value;

public class FilePathFactory {
    private static String reviewPicPath;
    private static String reportPath;
    private static String downloadUrl;

    private FilePathFactory() {
    }

    // 静态成员变量的自动注入
    @Value(value = "${file.review-pic-path}")
    public void setReviewPicPath(String reviewPicPath) {
        FilePathFactory.reviewPicPath = reviewPicPath;
    }

    @Value(value = "${file.report-path}")
    public void setReportPath(String reportPath) {
        FilePathFactory.reportPath = reportPath;
    }

    public static FilePath getFilePathInstance(FileType fileType) {
        FilePath filePath;
        switch (fileType) {
            case REVIEW_PIC:
                filePath = new ReviewPicPath(downloadUrl, reviewPicPath, FileType.REVIEW_PIC);
                break;
            case PDF_REPORT:
                filePath = new ReportPath(downloadUrl, reportPath, FileType.PDF_REPORT);
                break;
            default:
                throw new BadRequestException("不支持的文件种类！");
        }
        return filePath;
    }


}
