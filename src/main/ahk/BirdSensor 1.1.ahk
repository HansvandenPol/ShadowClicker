; Version of BirdSensor which includes trap times. The goal is to prioritise older traps to prevent de-spawns.

; ---------- START SCRIPT
f5::
dismantleTrapColor = 0xFF0000
dismantleOldColor = 0xFF0000
dismantleOldestColor = 0xFF0000

idleTrapColor = 0xFFFF00

caughtTrapColor = 0x00FF00
caughtOldColor = 0x00FF00
caughtOldestColor = 0x00FF00

fallenTrapColor = 0xAA00FF

searchWindowX1 = 105
searchWindowX2 = 485
searchWindowY1 = 84
searchWindowY2 = 346

foundTrap := []

Loop {
	if(foundTrap.Count() > 0){
		positions := getAbsolutePos()
		type := foundTrap[1]
		thePosX := foundTrap[2]
		thePosY := foundTrap[3]

		Random, offsetX, -6, 6
		Random, offsetY, 0, 15

		if(type = "f"){
			newX := positions[1] + (thePosX-20) + offsetX
			newY := positions[2] + (thePosY+10) + offsetY
		}else {
			newX := positions[1] + thePosX + offsetX
			newY := positions[2] + thePosY + offsetY
		}

		ControlSend, ,%type%`,%newX%`:%newY%{Enter},Windows PowerShell

		Random, random, 16000,16500

		Sleep, random

		foundTrap := []

		Continue
	} else {
		foundTrap := searchTrap()
	}

	Random, rand, 200, 210

	Sleep, rand
}

; ---------- STOP THE SCRIPT
f12::
ExitApp

getAbsolutePos(){
	WinGetPos, X, Y, width, heigth, RuneLite
	ar := [X,Y]
	return ar
}

searchTrap(){
		trap := []

	  ; Search for fallen traps
		PixelSearch, trapFallenX, trapFallenY,searchWindowX1,searchWindowY1,searchWindowX2, searchWindowY2, fallenTrapColor, 1, Fast, RGB

		if(ErrorLevel) {
		}else {
			trap := ["f", trapFallenX, trapFallenY]
			return trap
		}

    ; Search for caught traps (oldest first)
		PixelSearch, trapChtX, trapChtY,searchWindowX1,searchWindowY1,searchWindowX2, searchWindowY2, caughtOldestColor, 1, Fast
		if(ErrorLevel) {
		}else {
			trap := ["c",trapChtX, trapChtY]
			return trap
		}

		PixelSearch, trapChtX, trapChtY,searchWindowX1,searchWindowY1,searchWindowX2, searchWindowY2, caughtOldColor, 1, Fast
    if(ErrorLevel) {
    }else {
      trap := ["c",trapChtX, trapChtY]
      return trap
    }

    PixelSearch, trapChtX, trapChtY,searchWindowX1,searchWindowY1,searchWindowX2, searchWindowY2, caughtTrapColor, 1, Fast
    if(ErrorLevel) {
    }else {
      trap := ["c",trapChtX, trapChtY]
      return trap
    }

    ; Search for empty traps to dismantle (oldest first)
		PixelSearch, trapDisX, trapDisY,searchWindowX1,searchWindowY1,searchWindowX2, searchWindowY2, dismantleOldestColor, 1, Fast, RGB
		if(ErrorLevel) {

		}else {
			trap := ["d",trapDisX, trapDisY]
			return trap
		}

		PixelSearch, trapDisX, trapDisY,searchWindowX1,searchWindowY1,searchWindowX2, searchWindowY2, dismantleOldColor, 1, Fast, RGB
    if(ErrorLevel) {

    }else {
      trap := ["d",trapDisX, trapDisY]
      return trap
    }

    PixelSearch, trapDisX, trapDisY,searchWindowX1,searchWindowY1,searchWindowX2, searchWindowY2, dismantleTrapColor, 1, Fast, RGB
    if(ErrorLevel) {

    }else {
      trap := ["d",trapDisX, trapDisY]
      return trap
    }
}
