/*
 * Java Embedded Raspberry Pi GPIO app
 * LEDの点灯（エルチカ♪）
 *  * 用意するもの
 *  ジャンパーケーブル（オス×メス：２本）
 *  LED（RED 3.3v）
 *  抵抗 470Ω（黄・紫・茶・金）
 */
import java.io.File;
import java.io.FileWriter;

public class BlinkLED {
	static final String GPIO_OUT = "out";
	static final String GPIO_ON = "1";
	static final String GPIO_OFF = "0";
	static final String GPIO_CH = "25";

	public static void main(String[] args) {
		try {

			//Refresh GPIO_CH
			FileWriter unexport = new FileWriter("/sys/class/gpio/unexport");
			FileWriter export = new FileWriter("/sys/class/gpio/export");

			// Reset GPIO17
			File exportFileCheck = new File("/sys/class/gpio/gpio" + GPIO_CH);
			if (exportFileCheck.exists()) {
				unexport.write(GPIO_CH);
				unexport.flush();
			}

			export.write(GPIO_CH);
			export.flush();

			//Direction GPIO_CH
			FileWriter direction = new FileWriter("/sys/class/gpio/gpio" + GPIO_CH + "/direction");
			direction.write(GPIO_OUT);
			direction.flush();

			// Create GPIO Writer
			FileWriter command = new FileWriter("/sys/class/gpio/gpio"	+ GPIO_CH + "/value");

			// Brink Write
			for (int i = 0; i < 100; i++) {
				command.write(GPIO_ON);
				command.flush();
				Thread.sleep(200);
				command.write(GPIO_OFF);
				command.flush();
				Thread.sleep(200);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}