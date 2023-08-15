package base.print;

public class PrintResult {

    private void printErrorMessage(String errorCode) {
        String errorMessage = "";
        switch(errorCode) {
            case "select" : errorMessage = "조회에 실패하였습니다."; break;
            case "insert" : errorMessage = "등록에 실패하였습니다."; break;
            case "update" : errorMessage = "수정에 실패하였습니다."; break;
            case "delete" : errorMessage = "삭제에 실패하였습니다."; break;
        }
        System.out.println(errorMessage);
    }

    private void printSuccessMessage(String successCode) {
        String successMessage = "";
        switch(successCode) {
            case "select" : successMessage = "조회가 완료 되었습니다."; break;
            case "insert" : successMessage = "등록이 완료 되었습니다."; break;
            case "update" : successMessage = "수정이 완료 되었습니다."; break;
            case "delete" : successMessage = "삭제가 완료 되었습니다."; break;
        }
        System.out.println(successMessage);
    }

    public void checkResultCode(boolean isSuccess, String msg) {
        if(isSuccess) {
            printSuccessMessage(msg);
        } else {
            printErrorMessage(msg);
        }
    }

    public void printObject() {

    }
}
