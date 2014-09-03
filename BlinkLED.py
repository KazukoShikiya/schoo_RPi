    import RPi.GPIO as GPIO
    from time import sleep
     
    LED_PIN = 25
     
    print "Setting up GPIO"
    GPIO.setmode(GPIO.BCM)
    GPIO.setup(LED_PIN, GPIO.OUT)
     
    def enable_led(should_enable):
    if should_enable:
    GPIO.output(LED_PIN, False)
    else:
    GPIO.output(LED_PIN, True)
     
    enable_led(False)
    print "LED is OFF"
    sleep(2)
    enable_led(True)
    print "LED is ON"
    sleep(2)
    enable_led(False)
    print "LED is OFF"
    sleep(2)
    enable_led(True)
    print "LED is ON"
    sleep(2)
    GPIO.cleanup()
